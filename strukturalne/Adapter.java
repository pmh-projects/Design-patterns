package Strukturalne;

import java.io.IOException;
import java.text.MessageFormat;

/**
 * Structural Design Pattern Adapter
 **/

public class Adapter {
    public static void main(String[] args) throws IOException {
        Sensor celsjusz = new AdapterTemp(new FarenheitSensor());

        System.out.println(MessageFormat.format("Pokazywana przez Fahrenheit Sensor temperatura w Celsjuszach: {0}°C", celsjusz.GetTemperature()));
        System.in.read();
    }
}

abstract class Sensor {
    public abstract float GetTemperature();
}

class FarenheitSensor {

    float Temperatura = 99.4f;
    public float GetTemperatura() {
        return Temperatura;
    }
}

class AdapterTemp extends Sensor {
    FarenheitSensor _fs;

    public AdapterTemp(FarenheitSensor fs) {
        this._fs = fs;
    }
    @Override
    public float GetTemperature() {
        return (_fs.GetTemperatura() - 32.0f) * 5.0f / 9.0f;
    }
}