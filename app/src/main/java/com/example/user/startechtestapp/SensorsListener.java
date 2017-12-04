package com.example.user.startechtestapp;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

class SensorsListener {
    private SensorManager sensorManager;
    private Sensor accSensor, magSensor;
    private double [] tiltData ={0,0,0};
    private float [] orientation = {0,0,0};
    private float [] acceleration ={0,0,0};

    void InstantiateListener(Context context)
    {
        sensorManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
        if (sensorManager != null) {
            accSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
            magSensor = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        }
    }
    private SensorEventListener gyroListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            int type=event.sensor.getType();
            switch (type) {
                case Sensor.TYPE_ACCELEROMETER:
                    acceleration[0] = event.values[0];
                    acceleration[1] = event.values[1];
                    acceleration[2] = event.values[2];
                    break;
                case Sensor.TYPE_MAGNETIC_FIELD:
                    orientation[0] = event.values[0];
                    orientation[1] = event.values[1];
                    orientation[2] = event.values[2];
                    break;
            }
            if ((type==Sensor.TYPE_MAGNETIC_FIELD) || (type==Sensor.TYPE_ACCELEROMETER)) {
                tiltData = getOrientationUsingGetRotationMatrix(orientation, acceleration);
            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    };
    private static double [] getOrientationUsingGetRotationMatrix(float[] mGravityVector, float[] mMagneticFieldVector) {
        if (mGravityVector == null || mMagneticFieldVector == null) {
            return new double []{0,0,0};
        }
        float R[] = new float[9]; // will store matrix data
        float I[] = new float[9]; // will store matrix data
        boolean success = SensorManager.getRotationMatrix(R, I, mGravityVector, mMagneticFieldVector);
        if (success) {
            float rotationAngles[] = new float[3];
            SensorManager.getOrientation(R, rotationAngles);
            double alpha = rotationAngles[0]/Math.PI/2;
            double beta = rotationAngles[1]/Math.PI/2;
            double gamma = rotationAngles[2]/Math.PI/2;
            //Log.d("ANGLES","a: "+alpha+" b: "+beta);
            return new double[] {alpha, beta, gamma};
        }
        return new double []{0,0,0};
    }
    void start()
    {
        sensorManager.registerListener(gyroListener, accSensor, SensorManager.SENSOR_DELAY_FASTEST);
        sensorManager.registerListener(gyroListener, magSensor, SensorManager.SENSOR_DELAY_FASTEST);

    }
    void stop()
    {
        sensorManager.unregisterListener(gyroListener,accSensor);
        sensorManager.unregisterListener(gyroListener,magSensor);

    }
    double [] getTilt()
    {
        return tiltData;
    }
}