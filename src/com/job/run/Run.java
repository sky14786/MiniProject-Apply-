package com.job.run;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import com.job.view.ApplicationDeleteView;
import com.job.view.JobSearchView;
import com.job.view.LoginView;
import com.job.view.NoticeRegisterView;
import com.job.view.NoticeUpdateView;
import com.job.view.OwnerDetailView;
import com.job.view.OwnerMainView;
import com.job.view.OwnerSignUpView;
import com.job.view.PartMainView;
import com.job.view.PartimerSignUpView;
import com.job.view.ResumeModifyView;
import com.job.view.ResumeRegisterView;
import com.job.view.Search2View;
import com.job.view.SearchView;
import com.job.view.SignUpCategory;

public class Run extends JFrame {

	private LoginView loginView = null;
	private SignUpCategory signUpCategory = null;
	private PartimerSignUpView partimerSignView = null;
	private OwnerSignUpView ownerSignUpView = null;
	private NoticeRegisterView noticeRegisterView = null;
	private NoticeUpdateView noticeUpdateView = null;
	private OwnerMainView ownerMainView = null;
	private PartMainView partMainView = null;
	private ResumeRegisterView resumeEnrollView = null;
	private ResumeModifyView resumeModifyView = null;
	private JobSearchView jobSearchView = null;
	private ApplicationDeleteView applicationDeleteView = null;
	private SearchView searchView = null;
	private Search2View search2View = null;
	private OwnerDetailView ownerDetailView = null;

	public static void main(String[] args) {

		Run win = new Run();
		win.setTitle("æÀπŸ¿« πŒ¡∑");
		win.loginView = new LoginView(win);
		win.signUpCategory = new SignUpCategory(win);
		win.partimerSignView = new PartimerSignUpView(win);
		win.ownerSignUpView = new OwnerSignUpView(win);
		win.noticeRegisterView = new NoticeRegisterView(win);
		win.noticeUpdateView = new NoticeUpdateView(win);
		win.ownerMainView = new OwnerMainView(win);
		win.partMainView = new PartMainView(win);
		win.resumeEnrollView = new ResumeRegisterView(win);
		win.resumeModifyView = new ResumeModifyView(win);
		win.jobSearchView = new JobSearchView(win);
		win.applicationDeleteView = new ApplicationDeleteView(win);
		win.searchView = new SearchView(win);
		win.search2View = new Search2View(win);
		win.ownerDetailView = new OwnerDetailView(win);

		win.add(win.loginView);
		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		win.setSize(590, 590);
		win.setResizable(false);
		ImageIcon img = new ImageIcon(win.getClass().getResource("/resource/MainLogo.png"));
		win.setIconImage(img.getImage());
		win.setVisible(true);

	}

	// View Getter

	public SearchView getSearchView() {
		return searchView;
	}

	public Search2View getSearch2View() {
		return search2View;
	}

	public ApplicationDeleteView getApplicationDeleteView() {
		return applicationDeleteView;
	}

	public OwnerDetailView getOwnerDetailView() {
		return ownerDetailView;
	}

	public LoginView getLoginView() {
		return loginView;
	}

	public PartimerSignUpView getPartimerSignView() {
		return partimerSignView;
	}

	public OwnerSignUpView getOwnerSignUpView() {
		return ownerSignUpView;
	}

	public NoticeRegisterView getNoticeRegisterView() {
		return noticeRegisterView;
	}

	public NoticeUpdateView getNoticeUpdateView() {
		return noticeUpdateView;
	}

	public ResumeRegisterView getResumeEnrollView() {
		return resumeEnrollView;
	}

	public ResumeModifyView getResumeModifyView() {
		return resumeModifyView;
	}

	public JobSearchView getJobSearchView() {
		return jobSearchView;
	}

	public SignUpCategory getSignUpCategory() {
		return signUpCategory;
	}

	public OwnerMainView getOwnerMainView() {
		return ownerMainView;
	}

	public PartMainView getPartMainView() {
		return partMainView;
	}

}
