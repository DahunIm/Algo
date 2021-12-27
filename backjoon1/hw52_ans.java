package backjoon1;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

public class hw52_ans {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		Person[] p = new Person[N];

		for(int i = 0; i < N; i++) {
			p[i] = new Person(in.nextInt(), in.next());
		}
		
		// Ÿ���� Person ���� �� ��.
		Arrays.sort(p, new Comparator<Person>() {
			// ���̼����� ����
			@Override
			public int compare(Person s1, Person s2) {
				return s1.age - s2.age;
			}	
		});
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < N; i++) {
			// ��ü�迭�� ��ü�� ����ϸ� �ش� �ε����� ��ü�� toString() �� ��� ��
			sb.append(p[i]);
		}
		System.out.println(sb);
	}
	public static class Person {
		int age;
		String name;
		
		public Person(int age, String name) {
			this.age = age;
			this.name = name;
		}
		@Override
		public String toString() {
			return age + " " + name + "\n";
		}
	}
}
