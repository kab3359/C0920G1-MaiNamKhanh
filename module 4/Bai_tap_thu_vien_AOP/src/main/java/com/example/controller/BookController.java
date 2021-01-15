package com.example.controller;

import com.example.entity.Book;
import com.example.entity.CheckId;
import com.example.entity.Contract;
import com.example.service.BookService;
import com.example.service.ContractService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.Min;

@Controller
public class BookController {
    @Autowired
    BookService bookService;

    @Autowired
    ContractService contractService;

    @GetMapping
    public String showList(Model model, @CookieValue(value = "view", defaultValue = "0") Long count,
                           HttpServletRequest request, HttpServletResponse response){
        count++;
        request.getSession().setAttribute("count", count);
        Cookie cookie = new Cookie("view", count.toString());
        cookie.setMaxAge(60*60);
        response.addCookie(cookie);
        model.addAttribute("bookList", bookService.findAll());
        return "list";
    }

    @GetMapping("borrow/{id}")
    public String viewBorrowBook(@PathVariable int id, Model model){
        if(contractService.findById(contractService.createId()) != null){
            return "redirect:/borrow/{id}";
        }else {
            model.addAttribute("contract", new Contract(contractService.createId(), bookService.findById(id)));
            return "viewBorrow";
        }
    }

    @GetMapping("save")
    public String save(@ModelAttribute Contract contract){
        Book book = bookService.findById(contract.getBook().getId());
        book.setQuantity(book.getQuantity() - 1);
        bookService.save(book);
        contractService.save(contract);
        return "redirect:/";
    }

    @GetMapping("return/{id}")
    public String viewReturnBook(@PathVariable int id, Model model){
     model.addAttribute("contract", new Contract(0, bookService.findById(id)));
     return "viewReturn";
    }

    @GetMapping("deleteContract")
    public String delete(@Valid @ModelAttribute Contract contract, Model model, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "/viewReturn";
        }
        if(contractService.isEmpty(contract)){
            contractService.delete(contractService.findById(contract.getId()));
            Book book = bookService.findById(contract.getBook().getId());
            book.setQuantity(book.getQuantity() + 1);
            bookService.save(book);
            return "redirect:/";
        }else {
            model.addAttribute("message", "ko tìm thấy");
            return "/viewReturn";
        }

    }
}
