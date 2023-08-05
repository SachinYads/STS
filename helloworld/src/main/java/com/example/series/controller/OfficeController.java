package com.example.series.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.series.entity.Address;
import com.example.series.entity.Office;
import com.example.series.entity.OfficeFormData;
import com.example.series.service.OfficeService;

@Controller
public class OfficeController {
	@Autowired
	private OfficeService officeService;
	@GetMapping("/getoffice")
	public ModelAndView getOfficeById(@RequestParam("id") Long officeId){

		Office office = officeService.getOfficeById(officeId);

		ModelAndView mv = new ModelAndView();
		if(office!=null) {
		mv.addObject("office", office);
		mv.setViewName("officedisplay");
		}else {
			mv.addObject("msg","office with id"+officeId+"not found");
			mv.setViewName("officedisplaywitherror");
		}
		return mv;
	}
	

	@PostMapping("/saveoffice")
	public ModelAndView saveOffice(@ModelAttribute Office office){
	//public ModelAndView saveOffice(@ModelAttribute Office office,@ModelAttribute Address address) {
	public ModelAndView saveOffice(@ModelAttribute OfficeFormData officeFormData) {
		Office office = new Office();
		office.setOfficeName(officeFormData.getOfficeName());

		Office ofc = officeService.addOffice(office);

		Address address = new Address();
		address.setCity(officeFormData.getCity());
		address.setStreet(officeFormData.getStreet());
		address.setState(officeFormData.getState());
		address.setCountry(officeFormData.getCountry());
		address.setOffice(office);
		Set<Address> addressSet = new HashSet<Address>();
		addressSet.add(address);
		office.setAddress(addressSet);

		Office ofc = officeService.addOffice(office);

		ModelAndView mv = new ModelAndView();
		mv.addObject("office", ofc);
		mv.setViewName("officedisplay");
		

		return mv;
	}

	@GetMapping("/officeform")
	public ModelAndView getOfficeForm(@ModelAttribute Office office, @ModelAttribute Address address) {
		ModelAndView mv = new ModelAndView();

		mv.setViewName("officeform");

		return mv;
	}
}

