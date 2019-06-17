package com.job.model.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.job.model.Connection;
import com.job.model.Notice;
import com.job.model.Owner;
import com.job.model.Partimer;
import com.job.model.Resume;

public class LoadSave {

	private static LoadSave dao = new LoadSave();
	private int nowUser = 0;

	private LoadSave() {
	}

	public int getNowUser() {
		return nowUser;
	}

	public void setNowUser(int nowUser) {
		this.nowUser = nowUser;
	}

	public static LoadSave getDao() {
		return dao;
	}

	public ArrayList<Notice> loadNoitce() {
		ObjectInputStream ois = null;
		ArrayList<Notice> notices = new ArrayList<Notice>();
		File file = new File("notice.txt");
		if (file.isFile()) {
			try {
				FileInputStream fis = new FileInputStream(file);
				ois = new ObjectInputStream(fis);
				notices = (ArrayList<Notice>) ois.readObject();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					ois.close();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		}
		return notices;
	}

	public void saveNotice(ArrayList<Notice> notices) {
		ObjectInputStream ois = null;
		File file = new File("notice.txt");
		ObjectOutputStream oos = null;
		try {
			FileOutputStream fos = new FileOutputStream(file);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(notices);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public ArrayList<Owner> loadOnwer() {
		ObjectInputStream ois = null;
		ArrayList<Owner> owners = new ArrayList<Owner>();
		File file = new File("owner.txt");
		if (file.isFile()) {
			try {
				FileInputStream fis = new FileInputStream(file);
				ois = new ObjectInputStream(fis);
				owners = (ArrayList<Owner>) ois.readObject();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					ois.close();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		}
		return owners;
	}

	public void saveOwner(ArrayList<Owner> owners) {
		ObjectInputStream ois = null;
		File file = new File("owner.txt");
		ObjectOutputStream oos = null;
		try {
			FileOutputStream fos = new FileOutputStream(file);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(owners);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public ArrayList<Partimer> loadPartimer() {
		ObjectInputStream ois = null;
		ArrayList<Partimer> partimers = new ArrayList<Partimer>();
		File file = new File("partimer.txt");
		if (file.isFile()) {
			try {
				FileInputStream fis = new FileInputStream(file);
				ois = new ObjectInputStream(fis);
				partimers = (ArrayList<Partimer>) ois.readObject();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					ois.close();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		}
		return partimers;
	}

	public void savePartimer(ArrayList<Partimer> partimers) {
		ObjectInputStream ois = null;
		File file = new File("partimer.txt");
		ObjectOutputStream oos = null;
		try {
			FileOutputStream fos = new FileOutputStream(file);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(partimers);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public ArrayList<Resume> loadResume() {
		ObjectInputStream ois = null;
		ArrayList<Resume> resumes = new ArrayList<Resume>();
		File file = new File("resume.txt");
		if (file.isFile()) {
			try {
				FileInputStream fis = new FileInputStream(file);
				ois = new ObjectInputStream(fis);
				resumes = (ArrayList<Resume>) ois.readObject();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					ois.close();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		}
		return resumes;
	}

	public void saveResume(ArrayList<Resume> resumes) {
		ObjectInputStream ois = null;
		File file = new File("resume.txt");
		ObjectOutputStream oos = null;
		try {
			FileOutputStream fos = new FileOutputStream(file);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(resumes);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void saveConnection(ArrayList<Connection> connections) {
		ObjectInputStream ois = null;
		File file = new File("connection.txt");
		ObjectOutputStream oos = null;
		try {
			FileOutputStream fos = new FileOutputStream(file);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(connections);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public ArrayList<Connection> loadConnection() {
		ObjectInputStream ois = null;
		ArrayList<Connection> connections = new ArrayList<Connection>();
		File file = new File("connection.txt");
		if (file.isFile()) {
			try {
				FileInputStream fis = new FileInputStream(file);
				ois = new ObjectInputStream(fis);
				connections = (ArrayList<Connection>) ois.readObject();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					ois.close();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		}
		return connections;
	}
}
