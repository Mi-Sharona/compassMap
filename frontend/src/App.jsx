import { useState, useEffect } from "react";
import "./App.css";

function App() {
  const [preguntas, setPreguntas] = useState([]);

  useEffect(() => {
    fetch("http://localhost:8080/api/v1/questions/all")
      .then((respuesta) => respuesta.json())
      .then((datos) => setPreguntas(datos));
  }, []);

  return (
    <div className="contenedor">
      <h1 className="titulo">CompassMap</h1>
      <p>Tu futuro en programación, en pocos pasos 👋</p>
      <img className="gif" src="/gif programmer.gif" alt="Programador trabajando" />

      <h2>Preguntas del test</h2>
      <ul>
        {preguntas.map((pregunta) => (
          <li key={pregunta.id}>{pregunta.text}</li>
        ))}
      </ul>
    </div>
  );
}

export default App;