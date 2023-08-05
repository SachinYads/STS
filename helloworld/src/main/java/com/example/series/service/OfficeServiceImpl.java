package com.example.series.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.series.dao.OfficeRepository;
import com.example.series.entity.Office;

@Service
public class OfficeServiceImpl implements OfficeService {
	@Autowired
	private OfficeRepository officeRepo;
	@Override
	public Office getOfficeById(Long officeId) {
		Optional<Office> office =	officeRepo.findById(officeId);
				if(office.isPresent()) {
					return office.get();
				}else {
					return null;
				}
	}

	@Override
	public List<Office> getAllOffice() {

		return (List<Office>) officeRepo.findAll();
	}

	@Override
	public Office addOffice(Office office) {

		return officeRepo.save(office);
	}

	@Override
	public Office updateOffice(Office office) {
		if(officeRepo.existsById(office.getOfficeId())) {
			return	officeRepo.save(office);
		}else {
			return null;
		}

	}

	@Override
	public void deleteOfficeById(Long officeId) {
		officeRepo.deleteById(officeId);
	}

	@Override
	public void deleteAllOffice() {
		officeRepo.deleteAll();

	}

	@Override
	public Office getOfficeByName(String officeName) {
		// TODO Auto-generated method stub
		return null;
	}

	

	

}


