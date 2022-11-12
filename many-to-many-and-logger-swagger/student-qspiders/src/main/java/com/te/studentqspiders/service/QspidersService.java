package com.te.studentqspiders.service;

import com.te.studentqspiders.entity.Qspiders;
import com.te.studentqspiders.request.QspidersRequest;

public interface QspidersService {

	QspidersRequest addQspidersDetails(QspidersRequest request);

	Qspiders getQspidersDetails(Integer qspidersId);

	QspidersRequest updateQspiderDetails(QspidersRequest request);

	String deleteQspiderDetails(Integer qspiderId);

}
