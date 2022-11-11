package com.te.resumebuilder.service;

import static com.te.resumebuilder.constant.ProfileConstant.NO_RECORD_FOUND_EXCEPTION;
import static com.te.resumebuilder.constant.ProfileConstant.RES;
import static com.te.resumebuilder.constant.ProfileConstant.SOMETHING_WENT_WRONG_EXCEPTION;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.te.resumebuilder.customexception.NoRecordFoundException;
import com.te.resumebuilder.customexception.SomethingWentWrongException;
import com.te.resumebuilder.entity.Profile;
import com.te.resumebuilder.repository.ProfileRepository;
import com.te.resumebuilder.request.ProfileRequest;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {

	private final ProfileRepository repository;

	@Override
	public Profile addResumes(ProfileRequest request) {
		try {
			Profile profile = new Profile();
			BeanUtils.copyProperties(request, profile);
			List<Profile> list = repository.findAllByEmployeeId(request.getEmployeeId());
			profile.setResumeId(RES + request.getTotalExperience() + "_" + (list.size() + 1));
			return repository.save(profile);
		} catch (Exception exception) {
			throw new SomethingWentWrongException(SOMETHING_WENT_WRONG_EXCEPTION);
		}
	}

	@Override
	public List<String> getResumeByEmployeeId(String employeeId) {
		try {
			List<Profile> list = repository.findAllByEmployeeId(employeeId);
			List<String> list2 = list.stream().map(Profile::getResumeId).toList();
			if (list2.isEmpty()) {
				throw new NoRecordFoundException(NO_RECORD_FOUND_EXCEPTION);
			}
			return list2;
		} catch (NoRecordFoundException exception) {
			throw exception;
		} catch (Exception exception) {
			throw new SomethingWentWrongException(SOMETHING_WENT_WRONG_EXCEPTION);
		}
	}

	@Override
	public Profile getResumeByResumeIdAndEmployeeId(String resumeId, String employeeId) {
		try {
			return repository.findByResumeIdAndEmployeeId(resumeId, employeeId)
					.orElseThrow(() -> new NoRecordFoundException(NO_RECORD_FOUND_EXCEPTION));
		} catch (NoRecordFoundException exception) {
			throw exception;
		} catch (Exception exception) {
			throw new SomethingWentWrongException(SOMETHING_WENT_WRONG_EXCEPTION);
		}
	}

	@Override
	public Profile updateResumeByResumeIdAndEmployeeId(ProfileRequest request) {
		try {
			 Profile profile = repository.findByResumeIdAndEmployeeId(request.getResumeId(), request.getEmployeeId())
					.orElseThrow(() -> new NoRecordFoundException(NO_RECORD_FOUND_EXCEPTION));
			 
			 BeanUtils.copyProperties(request, profile);
			 String[] split = request.getResumeId().split("_");
			 profile.setResumeId(split[0]+"_"+request.getTotalExperience()+"_"+split[2]);
			 return repository.save(profile);
			 
		} catch (NoRecordFoundException exception) {
			throw exception;
		} catch (Exception exception) {
			throw new SomethingWentWrongException(SOMETHING_WENT_WRONG_EXCEPTION);
		}
	}

}
