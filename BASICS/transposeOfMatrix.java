
n == matrix length
  
for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                int val = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = val;

            }
        }
