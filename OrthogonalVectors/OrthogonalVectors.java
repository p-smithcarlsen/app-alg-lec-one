package OrthogonalVectors;

import java.util.Scanner;

public class OrthogonalVectors {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String[] params = sc.nextLine().split(" ");
		int N = Integer.parseInt(params[0]);
		int k = Integer.parseInt(params[1]);
		Vectors v = new Vectors(N, k);

		while (sc.hasNextLine()) {
			String[] vector = sc.nextLine().split(" ");
			if (vector.length == N)
				v.addVector(vector);
		}
		sc.close();

		v.findInnerProduct();
	}

	private static class Vectors {
		int[][] vectors;
		int sz;

		public Vectors(int N, int k) {
			vectors = new int[k*2][N];
		}

		public void addVector(String[] in) {
			int[] vector = new int[in.length];
			int len = in.length;
			for (int i = 0; i < len; i++) {
				vector[i] = Integer.parseInt(in[i]);
			}
			vectors[sz] = vector;
			sz++;
		}

		public void findInnerProduct() {
			int len = vectors.length;
			int halfWay = len/2;
			for (int i = 0; i < halfWay; i++) {
				for (int j = halfWay; j < len; j++) {
					boolean innerProduct = true;
					int innerLen = vectors[0].length;
					for (int h = 0; h < innerLen; h++) {
						if (!(vectors[i][h]*vectors[j][h] == 0))
							innerProduct = false;
					}
					if (innerProduct) {
						System.out.println("yes");
						return;
					}
				}
			}

			System.out.println("no");
		}

		public void printVectors() {
			for (int[] v : vectors) {
				for (int vv : v) {
					System.out.print(vv + " ");
				}
				System.out.println();
			}
		}
	}
}
