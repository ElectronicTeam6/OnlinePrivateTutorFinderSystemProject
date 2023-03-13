package com.optfs.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.optfs.entities.Books;
import com.optfs.exceptions.NullUserFound;
import com.optfs.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	BookRepository bookRepository;

	@Override
	public Books registerBooks(Books book) throws NullUserFound {
		if (book.getBookName().isBlank()|| book.getAuthorName().isEmpty()) {
			throw new NullUserFound("Error: Null value is not accepted.");
		}
		else if (book.getBookName().equals("string") || book.getAuthorName().equals("string") ) {
			throw new NullUserFound("Error: Null value is not accepted.");
		}
		return bookRepository.save(book);
	}

	@Override
	public List<Books> getAllBookss() {
		
		return bookRepository.findAll();
	}

	@Override
	public Books getBooksById(Integer pid) throws NullUserFound {
		if(pid == 0) {
			throw new NullUserFound("Null value is not excepted");
		}
		
		return bookRepository.getBookById(pid) ;
	}

	@Override
	public Books updateBooks(Books book) throws NullUserFound {
		Books p =  getBooksById(book.getId());
		
		if(p == null) {
			throw new NullUserFound("No Books Exixts with same this id: "+ book.getId());
		}
		
		return bookRepository.save(book);
	}

	@Override
	public String deleteBooks(Books book) throws NullUserFound {
Books p =  getBooksById(book.getId());
		
		if(p == null) {
			throw new NullUserFound("No Books Exixts with same this id: "+ book.getId());
		}
		bookRepository.delete(p);
		return "userDeleted Successfully";
	}

}
