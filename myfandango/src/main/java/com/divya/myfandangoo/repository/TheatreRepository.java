package com.divya.myfandangoo.repository;
import java.util.List;

import com.divya.myfandangoo.entity.Theatre;
public interface TheatreRepository {
	
	int add(Theatre theatre);
	List<Theatre> list();
	List<Theatre> list(int location);
}
