package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P2941_1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String target = br.readLine();
		
		List<String> list = new ArrayList<String>();
		list.add("c=");
		list.add("c-");
        list.add("dz=");
        list.add("d-");
        list.add("lj");
        list.add("nj");
        list.add("s=");
        list.add("z=");
        
        int s = 0;
        int cnt = 0;
        
        while (s < target.length()) {
        	cnt++;
        	s++;
        	
        	for (String cro : list) {
        		if (target.startsWith(cro, s - 1)) {
        			s += cro.length() - 1;
        			break;
        		}
        	}
        }
        System.out.println(cnt);
        br.close();

	}

}
