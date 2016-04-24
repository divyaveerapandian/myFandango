package com.divya.myfandangoo.repository;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import com.divya.myfandangoo.entity.Theatre;
import com.divya.myfandangoo.entity.impl.TheatreImpl;
@ContextConfiguration(locations = "classpath:spring-context.xml")
public class TestTheatreRepository extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private TheatreRepository theatreRepository;

//	@Rollback(false)
	@Test
	public void testAddheatre() {
		TheatreImpl theatre = new TheatreImpl();
		theatre.setTheatreId(1);
		theatre.setTheatreName("AMC SANTA MONICA 7 ");
		theatre.setTheatreLocation(90404);
		int list = theatreRepository.add(theatre);
		Assert.assertNotEquals(list,0);
	}

	//	@Rollback(false)
	@Test
	public void testListTheatre() {
		List<Theatre> list = theatreRepository.list();
		for (int i = 0; i < list.size(); i++) {
			System.out.println("");
			System.out.println(list.get(i).toString());
		}
		Assert.assertNotEquals(list.size(),0);
	}

	//	@Rollback(false)
	@Test
	public void testListTheatreByLocation() {
		int location = 90404;
		List<Theatre> list = theatreRepository.list(location);
		for (int i = 0; i < list.size(); i++) {
			System.out.println("");
			System.out.println(list.get(i).toString());
		}
		assertEquals(list.size(),3);
	}
}
