package Com.JournalApp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
@RestController
@RequestMapping("/journal")
public class AppController 
{
	Map<Long,JournalEntry> jn=new HashMap<>();
	@GetMapping
	public List<JournalEntry> getAll()
	{
		return new ArrayList(jn.values());
		
	}
	@GetMapping("/h")
	public String helth()
	{
		return "Ok";
	}
	@PostMapping
	public Boolean postData(@RequestBody JournalEntry myEntry)
	{
		jn.put(myEntry.getId() ,myEntry);
		return true;
		
		
	}
	@GetMapping("id/{myId}")
	public JournalEntry find(@PathVariable Long myId)
	{
		return jn.get(myId);
	}
	
	@DeleteMapping("id/{myId}")
	public boolean deleteData(@PathVariable Long myId )
	{
		jn.remove(myId);
		return true;
	}
	@PutMapping("id/{myId}")
	public boolean dataUpdate(@PathVariable Long myId,@RequestBody JournalEntry newJn)
	{
		jn.replace(myId, newJn);
		return true;
		
	}


}
