package kr.hs.study.dbTest.controller;


import kr.hs.study.dbTest.dto.*;
import kr.hs.study.dbTest.service.bookRequestService;
import kr.hs.study.dbTest.service.bookService;
import kr.hs.study.dbTest.service.commentService;
import kr.hs.study.dbTest.service.dbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.security.sasl.AuthenticationException;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class testController {

    @Autowired
    private dbService service;

    @Autowired
    private bookService bookservice;

    @Autowired
    private bookRequestService book_requestservice;

    @Autowired
    private commentService commentservice;

    @GetMapping("/")
    public String home(){
        return "index";
    }

    @GetMapping("/write")
    public String add(){
        return "write_form";
    }

    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @GetMapping("/infoupdate")
    public String infoupdate(){
        return "info_user";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // 세션 무효화
        return "redirect:/"; // 로그아웃 후 로그인 페이지로 리다이렉트
    }

    @GetMapping("/list")
    public String list(Model model){
        List<bookDTO> books = bookservice.read();
        model.addAttribute("books", books);
        return "booklist";
    }

    @PostMapping("/search")
    public String searchBook(@RequestParam String searchtext, Model model) {
        List<bookDTO> searchbooks = bookservice.search(searchtext);
        model.addAttribute("books", searchbooks);
        System.out.println("검색" + searchbooks);
        return "booklist";
    }

    @GetMapping("/main")
    public String main(Model model){
        List<bookDTO> books = bookservice.select();
        model.addAttribute("book", books);
        return "main";
    }

    @PostMapping("/adduser")
    public String adduser(buserDTO dto) {
        service.insert(dto);
        return "redirect:/";
    }

    @PostMapping("/login")
    public String login(buserDTO dto, HttpSession session) {
        try {
            buserDTO authenticatedUser = service.authenticate(dto.getEmail(), dto.getPassword());
            session.setAttribute("user", authenticatedUser);

            System.out.println(session.getId() + authenticatedUser.getRole());

            if(authenticatedUser.getRole().equals( "admin")) {
                System.out.println("오호");
                return "redirect:/admin";
            }
            else return "redirect:/main"; // 인증 성공 시 대시보드 페이지로 리다이렉트
        } catch (AuthenticationException e) {
            // 인증 실패 시 처리
            return "redirect:/"; // 로그인 페이지에 다시 머물기
        }
    }

    @GetMapping("/mypage")
    public String myPage(HttpSession session, Model model) {
        buserDTO authenticatedUser = (buserDTO) session.getAttribute("user");
        System.out.println(authenticatedUser);
        if (authenticatedUser != null) {
            model.addAttribute("user", authenticatedUser);
            return "mypage";
        } else {
            // 로그인되지 않은 경우 로그인 페이지로 리다이렉트 또는 다른 처리
            return "redirect:/login";
        }
    }

    @PostMapping("/request")
    public String book_request(bookRequestDTO dto, HttpSession session) {
        buserDTO authenticatedUser = (buserDTO) session.getAttribute("user");
        System.out.println("책요청 : "+authenticatedUser);
        dto.setBuser_id(authenticatedUser.getBuser_id());
        System.out.println("정보"+dto);
        book_requestservice.insert(dto);
        return "redirect:/write";
    }

    @GetMapping("/comment/{book_id}")
    public String read_book(@PathVariable String book_id, Model model){
        bookDTO dto = commentservice.read(book_id);
        model.addAttribute("book", dto);

        List<commentDTO> comments = commentservice.readcomment(book_id);
        model.addAttribute("comments", comments);
        System.out.println(comments);
        return "comment";
    }

    @PostMapping("/addcomment")
    public String addcomment(commentDTO dto, @RequestParam Integer book_id, HttpSession session, Model model) {
        buserDTO authenticatedUser = (buserDTO) session.getAttribute("user");
        dto.setBuser_id(Integer.valueOf(authenticatedUser.getBuser_id()));
        dto.setBook_id(book_id);

        commentservice.insert(dto);

        return "redirect:/comment/"+book_id;
    }


    @GetMapping("/user/{id}")
    public String readuser(HttpSession session, Model model) {
        buserDTO authenticatedUser = (buserDTO) session.getAttribute("user");
        buserDTO dto = service.select(authenticatedUser.getBuser_id());
        model.addAttribute("user", dto);
        return "info_user";
    }

    @PostMapping("/updateuser")
    public String updateuser(buserDTO dto, HttpSession session,Model model) {
        buserDTO authenticatedUser = (buserDTO) session.getAttribute("user");

        authenticatedUser.setName(dto.getName()); // 이름 업데이트
        authenticatedUser.setEmail(dto.getEmail()); // 이메일 업데이트

        model.addAttribute("user", authenticatedUser);
        dto.setBuser_id(authenticatedUser.getBuser_id());
        System.out.println(dto);
        service.update(dto);
        return "redirect:/mypage";

    }

    @GetMapping("/mycomment/{id}")
    public String readMyComment(HttpSession session, Model model) {
        buserDTO authenticatedUser = (buserDTO) session.getAttribute("user");
        Integer buser_id = authenticatedUser.getBuser_id(); // 잘 나옴
        commentDTO count = commentservice.mycomment(buser_id);
        System.out.println(count); // null
        model.addAttribute("count", count);

        List<commentDTO> comments = commentservice.mycomments(buser_id);
        model.addAttribute("comments", comments);

        return "mycomment";
    }

    @GetMapping("/delete/{id}")
    public String deletemycomment(@PathVariable String id, HttpSession session, Model model) {
        Integer comment_id = Integer.valueOf(id);
        commentservice.delete(comment_id);

        buserDTO authenticatedUser = (buserDTO) session.getAttribute("user");
        Integer buser_id = authenticatedUser.getBuser_id(); // 잘 나옴
        commentDTO count = commentservice.mycomment(buser_id);
        model.addAttribute("count", count);

        List<commentDTO> comments = commentservice.mycomments(buser_id);
        model.addAttribute("comments", comments);

        return "redirect:/mycomment/"+authenticatedUser.getBuser_id();
    }


    @GetMapping("/admin")
    public String admin(Model model){
        List<bookDTO> books = bookservice.read();
        model.addAttribute("books", books);
        return "admin";
    }
//    <a th:href="@{'/admin/update/'+${one.book_id}}" class="form_review">수정</a>
    @GetMapping("/bookupdate/{book_id}")
    public String updateBook(@PathVariable String book_id, Model model) {
        Integer book = Integer.valueOf(book_id);
        bookDTO dto1 = bookservice.bookread(book);
        model.addAttribute("book", dto1);
        List<categoryDTO> dto2 = bookservice.selectcg();
        System.out.println(dto2);
        model.addAttribute("categories", dto2);
        return "update_book";
    }

    @PostMapping("/updatebook")
    public String updatebook(bookDTO dto) {
        System.out.println(dto);
        bookservice.updatebook(dto);
        return "redirect:/admin";
    }
}
