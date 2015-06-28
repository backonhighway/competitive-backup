package paiza;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Paiza1 {
	
	public static void main(String args[]) throws Exception {
		// ���͎󂯎��
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] num = br.readLine().split(" ");
		int N = Integer.parseInt(num[0]); //���i�_��
		int D = Integer.parseInt(num[1]); //�L�����y�[������
		int[] pp = new int[N]; //���i�l�i
		int[] cp = new int[D]; //�L�����y�[���ݒ���z
		for(int i=0; i<N; i++){
			pp[i] = Integer.parseInt(br.readLine());
		}
		for(int i=0; i<D; i++){
			cp[i] = Integer.parseInt(br.readLine());
		}
		
		// �ȉ��v�Z�����B�\�[�g���Ċe�ݒ���z�ɑ΂��ē񕪒T��:O(D*NlogN)
		Arrays.sort(pp);
		
		for(int i=0; i<D; i++){
			int closemax = 0;
			for(int j=0; j<N; j++){
				int lb = -1; //�����C���f�b�N�X
				int ub = N; //����C���f�b�N�X
				int target = cp[i] - pp[j]; //�߂Â��������z
				
				while(lb + 1 < ub){
					int mid = (lb + ub) / 2;
					if(pp[mid] <= target){ //�����𖞂����Ή���mid<=ans<ub
						lb = mid;
					}else{ //�������Ȃ����lb<=ans<mid
						ub = mid;
					}
				}
				if(lb == j){ //�������͎̂g���Ȃ�
					lb -= 1;
				}
				if(lb < 0){ //���������̂��Ȃ�
					continue;
				}
				closemax = Math.max(closemax, pp[j] + pp[lb]);
			}
			System.out.println(closemax);
		}
	}
}
