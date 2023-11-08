package com.onesoft.ac.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.onesoft.ac.entity.AcEntity;

public interface AcRepository extends JpaRepository<AcEntity, Integer> {
	@Query(value = "select * from ac where brand like %?", nativeQuery = true)
	public List<AcEntity> filters(String pr);

	@Query(value = "select * from ac where color like %?", nativeQuery = true)
	public List<AcEntity> getColor(String cl);

	@Query(value = "select * from ac where rating >?", nativeQuery = true)
	public List<AcEntity> rating(float f);

	@Query(value = "select * from ac where price >? and rating >?", nativeQuery = true)
	public List<AcEntity> multi(@PathVariable int pr, @PathVariable float ft);

	@Query(value = "select max(price) from ac", nativeQuery = true)
	public int maximum();
	
	@Query(value = "select * from ac where price =(select max(price) from ac);", nativeQuery = true)
	public AcEntity maxval();
	
	@Query(value = "select * from ac order by price asc", nativeQuery = true)
	public List <AcEntity> acsending();

	@Query(value = "select * from ac where brand like %?", nativeQuery = true)
	public List<AcEntity> getdetail(String cl);
	
    @Query(value = "select * from ac where price >?", nativeQuery = true)
	public List<AcEntity> exception(int price);
		
	}



