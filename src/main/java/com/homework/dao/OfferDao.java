package com.homework.dao;

import java.util.List;

import com.homework.entity.Offer;

interface OfferDao {
 public void addOffer(Offer offer);
 public List<Offer> getAllOffer();
 public Offer getSingleOffer(int id);
 public void deleteOffer(int id);
 public void update(Offer offer);
 public List<Offer> getSearchByName(String companyName);
 public List<Offer> findPaginated(int pageNo, int pageSize);
}
