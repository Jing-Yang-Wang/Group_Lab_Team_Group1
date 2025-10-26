
package University.Persona.Faculty;

import University.Persona.Person;
import University.Department.Department;
import java.util.ArrayList;

/**
 * FacultyDirectory 用于管理学院教师信息。
 * 包含教师的创建、删除、查询与评分等功能。
 * @author kal bugrara
 */
public class FacultyDirectory {

    private Department department;
    private ArrayList<FacultyProfile> teacherlist;

    // 构造方法
    public FacultyDirectory(Department d) {
        this.department = d;
        this.teacherlist = new ArrayList<>();
    }

    // 获取教师列表
    public ArrayList<FacultyProfile> getTeacherlist() {
        return teacherlist;
    }

    // 设置教师列表
    public void setTeacherlist(ArrayList<FacultyProfile> teacherlist) {
        this.teacherlist = teacherlist;
    }

    // 删除某个教师档案
    public void deleteFaculty(FacultyProfile p) {
        teacherlist.remove(p);
    }

    // 用于在课程分配中显示教师列表
    public ArrayList<FacultyProfile> getTeacherList() {
        return teacherlist;
    }

    // 创建新的教师档案
    public FacultyProfile newFacultyProfile(Person p) {
        FacultyProfile sp = new FacultyProfile(p);
        teacherlist.add(sp);
        return sp;
    }

    // 获取当前评分最高的教师
    public FacultyProfile getTopProfessor() {
        double bestRatingSoFar = 0.0;
        FacultyProfile bestProfSoFar = null;

        for (FacultyProfile fp : teacherlist) {
            if (fp.getProfAverageOverallRating() > bestRatingSoFar) {
                bestRatingSoFar = fp.getProfAverageOverallRating();
                bestProfSoFar = fp;
            }
        }
        return bestProfSoFar;
    }

    // 根据 ID 查找教师
    public FacultyProfile findTeachingFaculty(String id) {
        for (FacultyProfile sp : teacherlist) {
            if (sp.isMatch(id)) {
                return sp;
            }
        }
        return null; // 未找到
    }

    // 获取所在部门
    public Department getDepartment() {
        return department;
    }
    
    public FacultyDirectory() {
    this.department = null;
    this.teacherlist = new ArrayList<>();
}


}
