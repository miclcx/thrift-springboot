    package com.intellif.jianyi;

    import com.intellif.jianyi.service.FaceSearchService;
    import org.apache.thrift.TException;
    import org.apache.thrift.protocol.TBinaryProtocol;
    import org.apache.thrift.transport.TSocket;
    import org.apache.thrift.transport.TTransportException;
    import org.junit.Test;
    import org.springframework.boot.Banner;
    import org.springframework.boot.SpringApplication;

    import java.io.*;
    import java.nio.ByteBuffer;

    public class ThriftTest {

        private TBinaryProtocol protocol;
        private TSocket transport;
        private String host="127.0.0.1";

        public void startThriftServer(){
            SpringApplication app = new SpringApplication(Application.class);
            app.setBannerMode(Banner.Mode.OFF);
            app.run("");
        }
        public byte[] getContent(String filePath) throws IOException {
            File file = new File(filePath);
            long fileSize = file.length();
            if (fileSize > Integer.MAX_VALUE) {
                System.out.println("file too big...");
                return null;
            }
            FileInputStream fi = new FileInputStream(file);
            byte[] buffer = new byte[(int) fileSize];
            int offset = 0;
            int numRead = 0;
            while (offset < buffer.length
                    && (numRead = fi.read(buffer, offset, buffer.length - offset)) >= 0) {
                offset += numRead;
            }
            // 确保所有数据均被读取
            if (offset != buffer.length) {
                throw new IOException("Could not completely read file "
                        + file.getName());
            }
            fi.close();
            System.out.println("buffer size="+buffer.length);
            return buffer;
        }

        @Test
        public void testConnect() throws TException {

            transport = new TSocket(host, 19090);
            protocol = new TBinaryProtocol(transport);
            FaceSearchService.Client faceSearchService = new FaceSearchService.Client(protocol);
            try {
                transport.open();
            } catch (TTransportException e) {
                e.printStackTrace();
            }

            try {
                System.out.println(faceSearchService.testConnect());
                long startTime = System.currentTimeMillis() - 3600*1000*24;
                long endTime = System.currentTimeMillis();
                String path = ThriftTest.class.getResource("/").getPath();

                ByteBuffer faceFeature = ByteBuffer.wrap(getContent(path+"com/intellif/jianyi/featureData"));
                long start = System.currentTimeMillis();
                System.out.println(faceSearchService.faceSearchCountAll(startTime,endTime,faceFeature,7,0.88));
                System.out.println("faceSearchCountAll spent:"+(System.currentTimeMillis() - start));

                Thread.sleep(1000);
                start = System.currentTimeMillis();
                System.out.println(faceSearchService.faceSearchCountByCamera(26,startTime,endTime,faceFeature,7,0.88));
                System.out.println("faceSearchCountAll spent:"+(System.currentTimeMillis() - start));

            } catch (TException e) {
                e.printStackTrace();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            transport.close();




        }
    }
