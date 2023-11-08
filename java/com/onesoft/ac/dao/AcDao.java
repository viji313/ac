package com.onesoft.ac.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.onesoft.ac.entity.AcEntity;
import com.onesoft.ac.repository.AcRepository;

@Repository
public class AcDao {
	@Autowired
	AcRepository ar;

	public String setValue(List<AcEntity> e) {
		ar.saveAll(e);
		return "Saved Successfully";
	}

	public String putData(AcEntity e) {
		ar.save(e);
		return "Updated";
	}

	public AcEntity getData(int a) {
		return ar.findById(a).get();
	}

	public String delData(int b) {
		ar.deleteById(b);
		return "deleted";
	}

	public List<AcEntity> fetchall() {
		return ar.findAll();
	}

	public String adding(AcEntity e) {
		ar.save(e);
		return "Saved";
	}

	public List<AcEntity> filters(String pr) {
		return ar.filters(pr);
	}

	public List<AcEntity> getColor(String cl) {
		return ar.getColor(cl);
	}

	public List<AcEntity> rating(float f) {
		return ar.rating(f);
	}

	public List<AcEntity> multi(@PathVariable int pr, @PathVariable float ft) {
		return ar.multi(pr, ft);
	}

	public int maximum() {

		return ar.maximum();
	}
	public AcEntity maxval() {
		return ar.maxval();
	}

	public List<AcEntity> acsending() {
		return ar.acsending();
	}

	public List<AcEntity> getdetail(String cl) {
		
	return ar.getdetail(cl);
	}
	public List<AcEntity>exception(int price) {
		return ar.exception(price);
	}

	public String setInput(AcEntity e) {
		ar.save(e);
		return "SAVED";
	}
}
