package in.ac.collegeservicemodule;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@RestController
public class ICollegeServiceController {
	


	@ControllerAdvice
		public class GlobalExceptionHandler {
			@ExceptionHandler(NullPointerException.class)
			public ResponseEntity<String> handleNullPointerException(NullPointerException e){
				return new ResponseEntity<>("A null value: "+e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
	
	
	@Autowired
	private ICollegeServiceService service;

	//Retrieve All
	@GetMapping("/icollegeservice")
	public List<ICollegeService> list()
	{
		return service.listAll();
	}
	
	//Retrieve By Id
	@GetMapping("/icollegeservice/{id}")
	public ResponseEntity<ICollegeService> get(@PathVariable Integer id)
	{
	try{
		ICollegeService icollegeservice =service.get(id);
		return new ResponseEntity<ICollegeService>(icollegeservice,HttpStatus.OK);
	}
	catch(Exception e)
	{
		return new ResponseEntity<ICollegeService>(HttpStatus.NOT_FOUND);
	}
	
}
	//create
	@PostMapping("/icollegeservice")
	public void save(@RequestBody ICollegeService icollegeservice)
	{
		service.save(icollegeservice);
	}
	
	//update
		@PutMapping("/icollegeservice/{id}")
		public ResponseEntity<?> update(@PathVariable Integer id,@RequestBody ICollegeService icollegeservice){
			try {
				ICollegeService existproduct = service.get(id);
				service.save(icollegeservice);
				return new ResponseEntity<>(HttpStatus.OK);
			}
			catch(Exception e) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				
			}
		}
	//Delete
	@DeleteMapping("/icollegeservice/{id}")
		public void delete(@PathVariable Integer id)
		{
			service.delete(id);
		}
}

