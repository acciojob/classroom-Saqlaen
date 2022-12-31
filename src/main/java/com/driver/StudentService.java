package com.driver;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    
    @Autowired
    private StudentRepository studentrepository;
    
    public String addMovies(Student mv ){
        return this.studentrepository.addMovieRepo(mv);
    }

    public String addDir(Teacher dr ){
        return this.studentrepository.addDirRepo(dr);
    }

    public String addPair( String mv, String dr ){
        return this.studentrepository.addPairRepo( mv, dr );
    }

    public Student getMovie( String name ){
        return this.studentrepository.getMovieRepo(name );
    }

    public Teacher getDirector( String name ){
        return this.studentrepository.getDirectorRepo(name);
    }

    public List<String> getMovieByDir(String name ){
        return this.studentrepository.getMovieList(name);
    }

    public List<String> getAllMovieService(){
        return this.studentrepository.getAllMovieRepo();
    }


    public String deleteDirWork( String name ){
        return this.studentrepository.deleteDirWorkRepo(name);
    }


    public String deleteEverythingRelatedtoPair(){
        return this.studentrepository.deleteAllMovieRelatedToDirector();
    }

    public StudentRepository getStudentrepository() {
        return studentrepository;
    }

    public void setStudentrepository(StudentRepository studentrepository) {
        this.studentrepository = studentrepository;
    }

    
}
