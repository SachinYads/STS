package com.jpa.test.entities;

public class Severity {
	private int critical;
    private int major;
    private int minor;

    public Severity(int critical, int major, int minor) {
        this.critical = critical;
        this.major = major;
        this.minor = minor;
    }


	public int getCritical() {
		return critical;
	}

	public void setCritical(int critical) {
		this.critical = critical;
	}

	public int getMajor() {
		return major;
	}

	public void setMajor(int major) {
		this.major = major;
	}

	public int getMinor() {
		return minor;
	}

	public void setMinor(int minor) {
		this.minor = minor;
	}

   
}



