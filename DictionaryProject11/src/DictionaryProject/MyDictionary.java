package DictionaryProject;

import java.util.List;




public class MyDictionary {
	private final String turkish = "assets/tureng.txt";
	public String english = "assets/engtur.txt";
	
	public Mapping mapping;
	public List<String> getTurkishWords;
	public List<String> getEnglishWords;
	
	public MyDictionary() {
		mapping = new Mapping();			
		getTurkishWords = FileApplications.file.readFile(turkish);
		getEnglishWords = FileApplications.file.readFile(english);
		
	} 
		
		
}	
