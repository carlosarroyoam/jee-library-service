package com.carlosarroyoam.book.service.resource;

import java.net.URI;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import com.carlosarroyoam.book.service.dto.AuthorResponse;
import com.carlosarroyoam.book.service.dto.BookResponse;
import com.carlosarroyoam.book.service.entity.Book;
import com.carlosarroyoam.book.service.service.BookService;

@Path("/books")
@ApplicationScoped
public class BookResource {

	@Inject
	private BookService bookService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAll() {
		List<BookResponse> books = bookService.findAll();
		return Response.ok(books).build();
	}

	@GET
	@Path("/{isbn}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findByIsbn(@Valid @Pattern(regexp = "[0-9]{10}") @PathParam("isbn") String isbn) {
		BookResponse bookByIsbn = bookService.findByIsbn(isbn);
		return Response.ok(bookByIsbn).build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response store(@Valid Book book) {
		BookResponse createdBook = bookService.store(book);
		URI locationUri = UriBuilder.fromResource(BookResource.class).path("/{isbn}")
				.resolveTemplate("isbn", createdBook.getIsbn()).build();
		return Response.created(locationUri).build();
	}

	@PUT
	@Path("/{isbn}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(@Valid @Pattern(regexp = "[\\d]{10}") @PathParam("isbn") String isbn, @Valid Book book) {
		bookService.update(isbn, book);
		return Response.noContent().build();
	}

	@DELETE
	@Path("/{isbn}")
	public Response deleteByIsbn(@Valid @Pattern(regexp = "[\\d]{10}") @PathParam("isbn") String isbn) {
		bookService.deleteByIsbn(isbn);
		return Response.noContent().build();
	}

	@GET
	@Path("/{isbn}/authors")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findBookAuthors(@Valid @Pattern(regexp = "[\\d]{10}") @PathParam("isbn") String isbn) {
		List<AuthorResponse> authors = bookService.findAuthorsByBookIsbn(isbn);
		return Response.ok(authors).build();
	}

}
