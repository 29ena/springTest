package kr.or.ddit.view;

import java.io.File;
import java.io.FileInputStream;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.View;

import kr.or.ddit.user.model.UserVo;

public class ProfileView implements View{

	private static final Logger logger = LoggerFactory.getLogger(ProfileView.class);
	
	@Override
	public String getContentType() {
		return "img";
	}

	@Override
	public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.debug("profileView.render()");
		UserVo userVo = (UserVo)model.get("userVo");	// UserController의 userVo 가져오기
		
		// path정보로 file을 읽어들여서
				ServletOutputStream sos = response.getOutputStream();
				FileInputStream fis = null;
				String filePath = null;

				// 사용자가 업로드한 파일이 존재할 경우 : path
				if (userVo.getPath() != null) {	
					filePath = userVo.getPath();
				} else {// 사용자가 업로드한 파일이 존재하지 않을 경우 : no_image.gif / application객체 갖고 올 때
					filePath = request.getServletContext().getRealPath("/img/no_image.gif");
					// webapp/img/no-image.gif
				}
				File file = new File(filePath);
				fis = new FileInputStream(file);

				byte[] buffer = new byte[512];

				// response객체에 스트림으로 써준다
				while (fis.read(buffer,	 0, 512) != -1) {
					sos.write(buffer);
				}

				fis.close();
				sos.close();
	}

}
