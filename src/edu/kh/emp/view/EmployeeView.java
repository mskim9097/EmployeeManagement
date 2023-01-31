package edu.kh.emp.view;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.List;

//import edu.kh.emp.model.dao.EmployeeDAO;
import edu.kh.emp.model.vo.Employee;

// 화면용 클래스( 입력(Scanner) / 출력(print()) )
public class EmployeeView {

	private Scanner sc = new Scanner(System.in);
	
	// DAO 객체 생성
	//private EmployeeDAO dao = new EmployeeDAO();
	
	
	
	// 메인 메뉴
	public void displayMenu() {
		
		int input = 0;
		
		do {
			try {
				System.out.println("---------------------------------------------------------");
				System.out.println("----- 사원 관리 프로그램 -----");
				System.out.println("1. 새로운 사원 정보 추가");
				System.out.println("2. 전체 사원 정보 조회");
				System.out.println("3. 사번이 일치하는 사원 정보 조회");
				System.out.println("4. 사번이 일치하는 사원 정보 수정");
				System.out.println("5. 사번이 일치하는 사원 정보 삭제");
				
				System.out.println("6. 입력 받은 부서와 일치하는 모든 사원 정보 조회");
				// selectDeptEmp()
				
				System.out.println("7. 입력 받은 급여 이상을 받는 모든 사원 정보 조회");
				// selectSalaryEmp()
				
				System.out.println("8. 부서별 급여 합 전체 조회");
				// selectDeptTotalSalary()
				// DB 조회 결과를 HashMap<String, Integer>에 옮겨 담아서 반환
				// 부서코드, 급여 합 조회
				
				System.out.println("9. 주민등록번호가 일치하는 사원 정보 조회");
				
				System.out.println("10. 직급별 급여 평균 조회");
				// selectJobAvgSalary()
				// DB 조회 결과를 HashMap<String, Double>에 옮겨 담아서 반환 
				// 직급명, 급여 평균(소수점 첫째자리) 조회
				
				
				System.out.println("0. 프로그램 종료");
				
				System.out.print("메뉴 선택 >> ");
				input = sc.nextInt();
				sc.nextLine(); //  추가!
				
				
				System.out.println();				
				
				
				switch(input) {
				case 1:  insertEmployee();   break;
				case 2:  selectAll();  break;
				case 3:  selectEmpId();   break;
				case 4:  updateEmployee();   break;
				case 5:  deleteEmployee();   break;
				case 6:  selectDeptEmp();   break;
				case 7:  selectSalaryEmp();   break;
				case 8:  selectDeptTotalSalary();   break;
				case 9:  selectEmpNo();   break;
				case 10: selectJobAvgSalary();   break;
				
				case 0:  System.out.println("프로그램을 종료합니다...");   break;
				default: System.out.println("메뉴에 존재하는 번호만 입력하세요.");
				}
				
				
			}catch(InputMismatchException e) {
				System.out.println("정수만 입력해주세요.");
				input = -1; // 반복문 첫 번째 바퀴에서 잘못 입력하면 종료되는 상황을 방지
				sc.nextLine(); // 입력 버퍼에 남아있는 잘못 입력된 문자열 제거해서
							   // 무한 반복 방지
			}
			
		}while(input != 0);
		
	}
	
	private List<Employee> empList = new ArrayList<Employee>();
	
	public EmployeeView() {
		empList.add(new Employee(1, "공길동", "111111-1111111", "gong@kh.com", "010-1111-1111", 1000000, "d1",
				"j1", "l1", 0.1, 5));
		empList.add(new Employee(2, "농길동", "222222-2222222", "nong@kh.com", "010-2222-2222", 2000000, "d2",
				"j2", "l2", 0.2, 4));
		empList.add(new Employee(3, "동길동", "333333-3333333", "dong@kh.com", "010-3333-3333", 3000000, "d3",
				"j3", "l3", 0.3, 3));
		empList.add(new Employee(4, "롱길동", "444444-4444444", "long@kh.com", "010-4444-4444", 4000000, "d4",
				"j4", "l4", 0.4, 2));
		empList.add(new Employee(5, "몽길동", "555555-5555555", "mong@kh.com", "010-5555-5555", 5000000, "d5",
				"j5", "l4", 0.5, 1));
		empList.add(new Employee(6, "봉길동", "111111-1111111", "gong@kh.com", "010-1111-1111", 1000000, "d1",
				"j1", "l1", 0.1, 5));
		empList.add(new Employee(7, "송길동", "222222-2222222", "nong@kh.com", "010-2222-2222", 2000000, "d2",
				"j2", "l2", 0.2, 4));
		empList.add(new Employee(8, "옹길동", "333333-3333333", "dong@kh.com", "010-3333-3333", 3000000, "d3",
				"j3", "l3", 0.3, 3));
		empList.add(new Employee(9, "종길동", "444444-4444444", "long@kh.com", "010-4444-4444", 4000000, "d4",
				"j4", "l4", 0.4, 2));
		empList.add(new Employee(10, "총길동", "555555-5555555", "mong@kh.com", "010-5555-5555", 5000000, "d5",
				"j5", "l4", 0.5, 1));
	}
	
	/**
	 * 전체 사원 정보 조회
	 */
	public void selectAll() {
		
		System.out.println("=====전체 사원 정보 조회=====");
		
		if(empList.isEmpty()) {
			System.out.println("사원 정보가 없습니다.");
		}
		printAll(empList);
		
	
	}
	
	
	/** 전달받은 사원 List 모두 출력
	 * @param empList
	 */
	public void printAll(List<Employee> empList) {
		for(Employee emp : empList) {
			System.out.println(emp);
		}
	}
	
	
	/**
	 * 사번이 일치하는 사원 정보 조회
	 */
	public void selectEmpId() throws InputMismatchException{
		
		System.out.println("=====사원 정보 조회=====");
		
		int empId = inputEmpId();
		
		boolean flag = true;
		
		for(Employee emp : empList) {
			
			if(empId == emp.getEmpId()) {
				printOne(emp);
				flag = false;
			}
		}
		
		if(flag) {
			System.out.println("검색결과가 없습니다.");
		}
	}
	
	
	/** 사번을 입력 받아 반환하는 메서드
	 * @return empId
	 */
	public int inputEmpId() {
		
		System.out.print("사번 입력 : ");
		int input = sc.nextInt();
		sc.nextLine();
		
		return input;
	}
	
	
	/** 사원 1명 정보 출력
	 * @param emp
	 */
	public void printOne(Employee emp) {
		System.out.println(emp.toString());	
	}
	
	
	/**
	 * 주민등록번호가 일치하는 사원 정보 조회
	 */
	public void selectEmpNo() throws InputMismatchException {
		
		System.out.println("=====사원 정보 조회=====");
		
		System.out.print("주민등록번호 입력 : ");
		String input = sc.next();
		
		boolean flag = true;
		
		for(Employee emp : empList) {
			if(input.equals(emp.getEmpNo())){
				printOne(emp);
				flag = false;
			}
		}
		
		if(flag) {
			System.out.println("검색결과가 없습니다.");
		}
	}
	
	
	/**
	 * 사원 정보 추가
	 */
	public void insertEmployee() throws InputMismatchException {
		System.out.println("=====사원 정보 추가=====");
		
		System.out.print("사원 번호 : ");
		int id = sc.nextInt();
		sc.nextLine();
		
		System.out.print("사원 이름 : ");
		String name = sc.next();
		
		System.out.print("주민등록번호 : ");
		String no = sc.next();
		
		System.out.print("이메일 : ");
		String email = sc.next();
		
		System.out.print("전화 번호 : ");
		String phone = sc.next();
		
		System.out.print("급여 : ");
		int salary = sc.nextInt();
		sc.nextLine();
		
		System.out.print("부서 코드 : ");
		String deptCode = sc.next();
		
		System.out.print("직급 코드 : ");
		String jobCode = sc.next();
		
		System.out.print("급여 등급 : ");
		String salLevel = sc.next();
		
		System.out.print("보너스 : ");
		double bonus = sc.nextDouble();
		sc.nextLine();
		
		System.out.print("사수 번호 : ");
		int managerId = sc.nextInt();
		
		if(empList.add(new Employee(id, name, no, email, phone, salary,
					deptCode, jobCode, salLevel, bonus, managerId))) {
			System.out.println("성공");
		} else {
			System.out.println("실패");
		}
		
	}
	
	
	/**
	 * 사번이 일치하는 사원 정보 수정(이메일, 전화번호, 급여)
	 */
	public void updateEmployee() throws InputMismatchException {
		
		System.out.println("=====사원 정보 수정=====");
		
		int empId = inputEmpId();
		
		boolean flag = true;
		
		for(Employee emp : empList) {
			if(empId == emp.getEmpId()) {
				System.out.print("수정할 이메일 : ");
				String email = sc.next();
				
				System.out.print("수정할 전화번호 : ");
				String phone = sc.next();
				
				System.out.print("수정할 급여 : ");
				int salary = sc.nextInt();
				
				emp.setEmail(email);
				emp.setPhone(phone);
				emp.setSalary(salary);
				
				System.out.println("사원 정보가 수정되었습니다.");
				flag = false;
			}
		}
		
		if(flag) {
			System.out.println("검색결과가 없습니다.");
		}
		
	}
	
	/**
	 * 사번이 일치하는 사원 정보 삭제
	 */
	public void deleteEmployee() throws InputMismatchException {
// 에러난거 나중에 확인		
		System.out.println("=====사원 정보 삭제=====");
		
		
		int empId = inputEmpId();
		
		boolean flag = true;
		
		if(empList.isEmpty()) {
			System.out.println("사원 정보가 없습니다.");
		}
		for(int i = 0; i < empList.size(); i++) {
			if(empList.get(i).getEmpId() == empId) {
				System.out.print("정말 삭제하시겠습니까?(Y/N)");
				char ch = sc.next().toUpperCase().charAt(0);
				if(ch == 'Y') {
					Employee temp = empList.remove(i);
					System.out.println("사번 " + temp.getEmpId() + "번 직원의 정보가 삭제되었습니다");
					flag = false;
				} else {
					System.out.println("취소되었습니다");
					flag = false;
				}
			}
		}
		if(flag) {
			System.out.println("검색결과가 없습니다");
		}
		
	}
	
	
	/**
	 * 입력 받은 부서와 일치하는 모든 사원 정보 조회
	 */
	public void selectDeptEmp() throws InputMismatchException {
		
		System.out.println("=====부서 내 사원 정보 조회=====");
		
		System.out.print("부서 코드 : ");
		String input = sc.next();
		
		boolean flag = true;
		
		for(Employee emp : empList) {
			if(input.equals(emp.getDeptCode())) {
				printOne(emp);
				flag = false;
			}
		}
		
		if(flag) {
			System.out.println("잘못 입력하셨습니다.");
		}		
		
	}
	
	/**
	 * 입력 받은 급여 이상을 받는 모든 사원 정보 조회
	 */
	public void selectSalaryEmp() throws InputMismatchException {
		
		System.out.println("=====입력 급여 이상 사원 조회=====");
		
		System.out.print("급여 입력 : ");
		int input = sc.nextInt();
		sc.nextLine();
		
		boolean flag = true;
		
		System.out.println(input + "원 이상 급여를 받는 직원");
		for(Employee emp : empList) {
			if(emp.getSalary() >= input) {
				printOne(emp);
				flag = false;
			}
		}
		if(flag) {
			System.out.println("입력된 급여 이상을 받는 직원이 없습니다.");
		}
		
	}
	
	/**
	 * 부서별 급여 합 전체 조회
	 */
	public void selectDeptTotalSalary() {
		// DB 조회 결과를 HashMap<String, Integer>에 옮겨 담아서 반환
		// 부서코드, 급여 합 조회
		// 나중에 다시하기
		System.out.println("=====부서별 급여 합=====");
		
		
	}
	
	/**
	 * 직급별 급여 평균 조회
	 */
	public void selectJobAvgSalary() {
		// DB 조회 결과를 HashMap<String, Double>에 옮겨 담아서 반환 
		// 직급명, 급여 평균(소수점 첫째자리) 조회
		
		
	}
	
	
	
}