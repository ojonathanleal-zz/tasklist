package br.com.supero;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
public class TaskRest {
	
	@Autowired
	private TaskRepository repository;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Task>> getAll() {
		List<Task> tasks = repository.findAll();
		return new ResponseEntity<>(tasks, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ResponseEntity<Task> getById(@PathVariable("id") Long id) {
		Task task = repository.findOne(id);
		return Optional.ofNullable(task)
				.map(result -> new ResponseEntity<>(result, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Task> create(@RequestBody Task task) {
		Task newTask = repository.save(task);
		return new ResponseEntity<>(newTask, HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Task> update(@RequestBody Task task) {
		Task updateTask = repository.save(task);
		return new ResponseEntity<>(updateTask, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
		repository.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
