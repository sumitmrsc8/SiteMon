package sitemonitoringagain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sitemonitoringagain.repository.CheckRepository;
import java.util.*;
import sitemonitoringagain.entity.*;

@Service
public class CheckService {
	@Autowired
	private CheckRepository checkRepository;
	
	public List<Check> findAll(){
			return checkRepository.findAll();
		
	}
	
	public void save(Check check){
		checkRepository.save(check);
	}
	
	public void remove(Check check){
		checkRepository.delete(check);
		
	}
}
