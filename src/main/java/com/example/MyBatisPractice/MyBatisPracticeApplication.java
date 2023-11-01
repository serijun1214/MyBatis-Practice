package com.example.MyBatisPractice;

import com.example.MyBatisPractice.entity.FloorPlan;
import com.example.MyBatisPractice.entity.Mansion;
import com.example.MyBatisPractice.repository.FloorPlanRepository;
import com.example.MyBatisPractice.repository.MansionRepository;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
//Mapperインターフェースのパス(FQCN)を記述
//これを記述しない場合は、Mapperインターフェースに@Mapperをつける
@MapperScan("com.example.MyBatisPractice.repository")
public class MyBatisPracticeApplication {

	@Autowired //インスタンスをもらう
	MansionRepository mansionRepository;

	@Autowired //インスタンスをもらう
	FloorPlanRepository floorPlanRepository;

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(MyBatisPracticeApplication.class, args);
		MyBatisPracticeApplication app = context.getBean(MyBatisPracticeApplication.class);
		app.execute();
	}

	private void execute() {
		List<Mansion> list = mansionRepository.selectAll();
		System.out.println(list);

		Mansion mansion = mansionRepository.selectById(1);
		System.out.println(mansion);

		mansion = new Mansion();
		mansion.setStatus(true);
		list = mansionRepository.selectByStatusBuildingDate(mansion);
		System.out.println(list);

		mansion = new Mansion();
		mansion.setStatus(true);
		mansion.setBuildingDate(Date.valueOf("2010-05-01"));
		list = mansionRepository.selectByStatusBuildingDate(mansion);
		System.out.println(list);

		mansion = new Mansion();
		mansion.setFloorPlanId(1);
		List<Mansion> result = mansionRepository.selectByFloorPlanIdBuildingDateStatus(mansion);
		System.out.println(result);

		mansion = new Mansion();
		mansion.setBuildingDate(Date.valueOf("2010-01-01"));
		result = mansionRepository.selectByFloorPlanIdBuildingDateStatus(mansion);
		System.out.println(result);

		mansion = new Mansion();
		mansionRepository.selectByFloorPlanIdBuildingDateStatus(mansion);
		System.out.println(result);

		List<Integer> idList= new ArrayList<Integer>();
		idList.add(1);
		idList.add(2);
		idList.add(4);
		list = mansionRepository.selectByIdIN(idList);
		System.out.println(list);

		list=mansionRepository.selectByStationLIKE("宮");
		System.out.println(list);

		mansion = new Mansion();
		mansion.setName("ローズガーデンハイツ");
		mansion.setStation("大井町駅");
		result=mansionRepository.selectByNameStation(mansion);
		System.out.println(result);

		mansion = new Mansion();
		mansion.setName("サニーハイツ");
		mansion.setAddress("東京都品川区東大井ｘｘｘ");
		mansion.setStation("大井町駅");
		mansion.setFloorPlanId(1);
		mansion.setBuildingDate(Date.valueOf("2023-04-01"));
		mansion.setStatus(true);
		mansionRepository.insert(mansion);

		mansion = new Mansion();
		mansion.setId(1);
		mansion.setName("GreenHills");
		mansion.setAddress("東京都渋谷区渋谷111");
		mansion.setStation("JR渋谷駅");
		mansionRepository.update(mansion);

		List<FloorPlan> result2 = floorPlanRepository. selectByFloorPlanIdWithMansion (1);
		System.out.println(result2);

		Mansion result3 = mansionRepository.selectByIdWithFloorPlan(2);
		System.out.println(result3);
	}
}
