package Cube.Move;

class Orientation {

    static class CO {
        /**
         *
         * @param parts パーツ番号
         * @param count 0:1回 1:2回 2:3回
         * @return
         */
        static int ClockWise(int parts, int count){
            int co = parts;
            switch (parts) {
                case 0:
                    co = count == 1 ? 1 : 2;
                    break;
                case 1:
                    co = count == 1 ? 2 : 0;
                    break;
                case 2:
                    co = count == 1 ? 0 : 1;
                    break;
            }
            return co;
        }
    }

    static class EO{
        static int ClockWise(int parts){
            return parts == 0 ? 1 : 0 ;
        }
    }
}
