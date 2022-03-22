package com.homework.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.homework.dao.OfferDaoImpl;
import com.homework.entity.Offer;
import com.homework.service.OfferServiceImpl;

@Controller
public class Offercontroller {
	@Autowired
    private OfferDaoImpl offerDaoImpl;
	@Autowired
	private OfferServiceImpl offerServiceImpl;
	
	
	@RequestMapping("/getAllOffer")
 public String allOffer(Model model) {
		List<Offer> allOffer =offerDaoImpl.getAllOffer();
		//sSystem.out.println("hello" +allOffer);
		model.addAttribute("allOffers", allOffer);
		return "all-Offer";
		//return findPaginated(2,model);
	}

   @RequestMapping("/offer")
   public String insertOffer(@ModelAttribute("offer") Offer offer) {  
	   return "addOffer";
   }
   @RequestMapping("/processOffer")
   public String processOffer(Offer offer) {
	   if(offer.getId() == 0) {
		   offerServiceImpl.addOffer(offer);
	   }else {
		   offerServiceImpl.update(offer);
	   }
	   System.out.println(offer);
	   return "redirect:/getAllOffer";
   }
   
   @RequestMapping("/deleteOffer")
   public String deleteOffer(@RequestParam("offerId") int id) {
	   offerDaoImpl.deleteOffer(id);
	   return"redirect:/getAllOffer";
   }
   
   @RequestMapping("/updateOffer")
   public String updateOffer(@RequestParam("offerId") int id, Model model) {
	  Offer offerSingle =offerDaoImpl.getSingleOffer(id);
      model.addAttribute("offer", offerSingle);
	  return "addOffer";
   }
   @RequestMapping("/search")
   public String search(@RequestParam("keyword") String offerDetails , Model model) {
	  List<Offer> offer = offerDaoImpl.getSearchByName(offerDetails);
	  System.out.println("from search method "+offer.toString());
	  model.addAttribute("searchObject", offer);
	 return "search";
   }
   @RequestMapping("/page")
   public String findPaginated(@RequestParam(value="page") int page , Model model) {
	 int startpage = 1;
     int endpage = startpage + 10;
	 model.addAttribute("allOffers", offerDaoImpl.findPaginated(page, 3));
	 
	 model.addAttribute("startpage", startpage);
	 model.addAttribute("endpage", endpage);
	 return "all-Offer";
   }
}
