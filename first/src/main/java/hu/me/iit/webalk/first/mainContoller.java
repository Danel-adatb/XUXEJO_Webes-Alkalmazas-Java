package hu.me.iit.webalk.first;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class mainContoller {
	private final List<ArticleDto> articles = new ArrayList<>();
	
	
	@GetMapping(path="articles/", produces=MediaType.APPLICATION_JSON_VALUE)
	List<ArticleDto> allArticles() {
		return articles;
	}
	
	@PostMapping(path="articles/")
	void newArticle(@RequestBody ArticleDto articlesDto) {
		articles.add(articlesDto);
	}
	
	@PutMapping(path="articles/{id}")
	void ReplaceArticle(@PathVariable("id") String id, @RequestBody ArticleDto articleDto) {
		int num = -1;
		for (int i = 0; i < articles.size(); i++) {
			if(articles.get(i).getTitle().equals(id)) {
				num = i;
				break;
			}
		}
		
		if(num != -1) {
			ArticleDto foundArticles = articles.get(num);
			foundArticles.setAuthor(articleDto.getAuthor());
			foundArticles.setPages(articleDto.getPages());
		}
	}
	
	@DeleteMapping(path="articles/{id}")
	void deleteArticle(@PathVariable("id") String id) {
		int num = -1;
		for (int i = 0; i < articles.size(); i++) {
			if(articles.get(i).getTitle().equals(id)) {
				num = i;
				break;
			}
		}
		
		if(num != -1) {
			articles.remove(num);
		}
	}
}
