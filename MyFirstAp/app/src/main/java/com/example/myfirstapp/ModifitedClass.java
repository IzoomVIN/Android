package com.example.myfirstapp;

class ModifitedClass {
    ModifitedClass(){}

    public static String spiralMatrixFromString(String arr){
        String[] array;
        if(arr.lastIndexOf(", ") != -1) {
            array = arr.split(", ");
        }else{
            char[] array2 = arr.toCharArray();
            array = new String[array2.length];
            for(int i = 0; i < array2.length; i++){
                array[i] = String.valueOf(array2[i]);
            }
            array2 = null;
        }
        String out = "";

        int d = (int) Math.sqrt(array.length);
        d = (d*d < array.length) ? d+1 : d;
        d = (d%2!=0) ? d : d + 1;

        String[][] outArray = new String[d][d];

        int c = d/2;
        int indA = 0;
        int iMatr = c;
        int jMatr = c;
        int k = 1;

        while(true){
            outArray[iMatr][jMatr] = array[indA];
            indA++;

            switch (k){
                case 1:
                    iMatr++;
                    break;
                case 2:
                    jMatr++;
                    break;
                case 3:
                    iMatr--;
                    break;
                case 4:
                    jMatr--;
                    break;
            }

            if ((iMatr == d) || (indA >= array.length)){ break;}
            if ((jMatr == iMatr ) && (jMatr <= c)){
                k = 1;
            }else if ((jMatr + iMatr == d) && (iMatr > c) && (jMatr <= c)){
                k = 2;
            }else if ((jMatr == iMatr ) && (jMatr > c)){
                k = 3;
            }else if ((jMatr + iMatr == d - 1) && (iMatr < c) && (jMatr > c)){
                k = 4;
            }
        }

        int maxLenght = 0;

        for (int i = 0; i < d; i++){
            for (int j = 0; j < d; j++) {
                if(outArray[j][i] == null){
                    continue;
                }else if (maxLenght < outArray[j][i].length()){
                    maxLenght = outArray[j][i].length();
                }
            }
        }

        for (int i = 0; i < d; i++){
            for (int j = 0; j < d; j++){
                if(outArray[j][i] == null){
                    outArray[j][i] = ".";
                }
                if (outArray[j][i].length() < maxLenght){
                    for (int len = outArray[j][i].length(); len < maxLenght; len++){
                        outArray[j][i] = " " + outArray[j][i];
                    }
                }
            }
        }

        for (int i = 0; i < d; i++){
            for (int j = 0; j < d; j++){
                out += (outArray[j][i] + " ");
            }
            out += "\n";
        }

        return out;
    }
}
