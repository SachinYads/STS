package com.example.series.service;


import com.example.series.entity.Office;
import java.util.List;

public interface OfficeService {
	//Retrieve
		public Office getOfficeById(Long officeId);
		public List<Office> getAllOffice();
		//Create
		public Office addOffice(Office office);

		//Update
		public Office updateOffice(Office office);

		//Delete
		public void deleteOfficeById(Long officeId);
		public void deleteAllOffice();

		//Search
		public Office getOfficeByName(String officeName);
}
