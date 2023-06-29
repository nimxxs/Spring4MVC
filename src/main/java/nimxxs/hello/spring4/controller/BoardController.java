package nimxxs.hello.spring4.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class BoardController {

    private Logger logger = LogManager.getLogger(BoardController.class);

    @GetMapping("/board/list")
    public String list(Model m) {

        logger.info("board/list 호출!");

        return "board/list.tiles";
    }


}
