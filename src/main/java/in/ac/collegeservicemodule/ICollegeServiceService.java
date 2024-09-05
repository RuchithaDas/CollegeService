package in.ac.collegeservicemodule;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class ICollegeServiceService {
	@Autowired
	private ICollegeRepository repository;
	
	//Retrieve All
	public List<ICollegeService> listAll(){
		return repository.findAll();
	}
		
		//Retrieve By Id
		public ICollegeService get(Integer id)
		{
			return repository.findById(id).get();
	}
		//Creation
		public void save(ICollegeService icollegeservice)
		{
			repository.save(icollegeservice);
		}
		
		//Delete
		public void delete(Integer id)
		{
			repository.deleteById(id);
		}
}
