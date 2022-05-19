package com.bnta.library_store;

import com.bnta.library_store.models.Book;
import com.bnta.library_store.models.Library;
import com.bnta.library_store.repositories.BookRepository;
import com.bnta.library_store.repositories.LibraryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class LibraryStoreApplicationTests {

	@Autowired
	BookRepository bookRepository;

	@Autowired
	LibraryRepository libraryRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void canFindBookByName(){
		List<Book> found = bookRepository.findBookByName("The Lord Of The Rings");
		assertThat(found.size()).isEqualTo(1);
	}

	@Test
	public void canFindBookByAuthor(){
		List<Book> found1 = bookRepository.findBookByAuthor("Joanne Rowling");
		assertThat(found1.size()).isEqualTo(5);
	}
	
	@Test
	public void canFindBookByNameContaining(){
		List<Book> found2 = bookRepository.findBookByNameContaining("Harry Potter");
		assertThat(found2.size()).isEqualTo(5);

	}

//	@Test
//	public void canFindBookByNameAndLibrary(){
//		Library library1 = new Library("John Barnes Library", "Holloway");
//		Book book1 = new Book("The Lord Of The Rings", "John Tolkien", library1);
//
//
//		List<Book> found3 = bookRepository.findBookByNameAndLibrary("The Lord Of The Rings", library1);
//		assertThat(found3.size()).isEqualTo(1);
//
//	}

}

