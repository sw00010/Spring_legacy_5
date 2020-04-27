package com.iu.s5.board.file;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/boardFile/**")
public class BoardFileController {
	
	@Autowired
	private BoardFileService boardFileService;

	
	@GetMapping("fileDown")
	public ModelAndView fileDown(BoardFileVO boardFileVO)throws Exception {
		
		ModelAndView mv = new ModelAndView();
		boardFileVO = boardFileService.fileSelect(boardFileVO);
		mv.addObject("file", boardFileVO);
		mv.setViewName("fileDown");
		
		return mv;
		
		
	}
	
	@PostMapping("fileDelete")
	public ModelAndView fileDelete(long fileNum)throws Exception{
		ModelAndView mv = new ModelAndView();
		System.out.println(fileNum);
		int result = boardFileService.fileDelete(fileNum);
		mv.addObject("result", result);
		mv.setViewName("common/ajaxResult");
		return mv;
	}
	
}
