package com.example.Assignment.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class MarkSheet {
@Id
		Integer student_id ;
		Integer telugu_marks;
		Integer  hindi_marks ;
		Integer english_marks ;
		Integer maths_marks ;
		Integer science_marks ;
		Integer social_marks;
		public MarkSheet(Integer student_id, Integer telugu_marks, Integer hindi_marks, Integer english_marks,
				Integer maths_marks, Integer science_marks, Integer social_marks) {
			super();
			this.student_id = student_id;
			this.telugu_marks = telugu_marks;
			this.hindi_marks = hindi_marks;
			this.english_marks = english_marks;
			this.maths_marks = maths_marks;
			this.science_marks = science_marks;
			this.social_marks = social_marks;
		}
		public MarkSheet() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Integer getStudent_id() {
			return student_id;
		}
		public void setStudent_id(Integer student_id) {
			this.student_id = student_id;
		}
		public Integer getTelugu_marks() {
			return telugu_marks;
		}
		public void setTelugu_marks(Integer telugu_marks) {
			this.telugu_marks = telugu_marks;
		}
		public Integer getHindi_marks() {
			return hindi_marks;
		}
		public void setHindi_marks(Integer hindi_marks) {
			this.hindi_marks = hindi_marks;
		}
		public Integer getEnglish_marks() {
			return english_marks;
		}
		public void setEnglish_marks(Integer english_marks) {
			this.english_marks = english_marks;
		}
		public Integer getMaths_marks() {
			return maths_marks;
		}
		public void setMaths_marks(Integer maths_marks) {
			this.maths_marks = maths_marks;
		}
		public Integer getScience_marks() {
			return science_marks;
		}
		public void setScience_marks(Integer science_marks) {
			this.science_marks = science_marks;
		}
		public Integer getSocial_marks() {
			return social_marks;
		}
		public void setSocial_marks(Integer social_marks) {
			this.social_marks = social_marks;
		}
		@Override
		public String toString() {
			return "MarkSheet [student_id=" + student_id + ", telugu_marks=" + telugu_marks + ", hindi_marks="
					+ hindi_marks + ", english_marks=" + english_marks + ", maths_marks=" + maths_marks
					+ ", science_marks=" + science_marks + ", social_marks=" + social_marks + "]";
		}
		
}
