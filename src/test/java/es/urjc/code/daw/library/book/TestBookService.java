package es.urjc.code.daw.library.book;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import es.urjc.code.daw.library.notification.NotificationService;


class TestBookService {
	private Book book;
	private BookService bookService;
	private NotificationService notification;
	private BookRepository repository;
	@BeforeEach
	void setUp() {
		book = mock(Book.class);
		when(book.getTitle()).thenReturn("A wolf in the sky");
		when(book.getId()).thenReturn((long) 98);
		
		repository = mock(BookRepository.class);
		when(repository.save(book)).thenReturn(book);
		
		notification = mock(NotificationService.class);
		
		bookService = new BookService(repository,notification);
		
	}

	@Test
	void checkIfABookIsSavedInRepositoryAndNotificationIsSent() {
		bookService.save(book);
		verify(repository, times(1)).save(book);
		verify(notification, times(1)).notify("Book Event: book with title="+book.getTitle()+" was created");
	}
	@Test
	void checkIfABookIsDeletedAndNotificationIsSent() {
		bookService.save(book);
		bookService.delete(book.getId());
		verify(repository, times(1)).deleteById(book.getId());
		verify(notification, times(1)).notify("Book Event: book with id="+book.getId()+" was deleted");
		
	}
}
