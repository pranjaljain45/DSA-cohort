
n == matrix length


for (int i = 0; i < n; i++) {

            /*
            har baar do elemets ko swap kr rhe hai 1st & last isliye j half col hi travel karega
            */
            
            for (int j = 0; j < n / 2; j++) {

                int temp = matrix[i][j];
            
                matrix[i][j] = matrix[i][n - 1 - j];
                
                matrix[i][n - 1 - j] = temp;

            }
        }
