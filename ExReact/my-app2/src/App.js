// import logo from './logo.svg';
import './App.css';
import {useState, useEffect} from 'react'




// "App" is a 'function component'that represents a portion of of the view alomg with its logic.
// 'Class component' is no longer utilized

const App = () => {

    const [counter, setCounter] = useState (0);

    useEffect (() => {
      // alert('Reload')
      setCounter(100);
    }, [])
  // const Person = (props) => {
  //   return (
  //     <>
  //     <h1>Name : {props.name}</h1>
  //     <h2>Last Name : {props.lastName}</h2>
  //     <h2>Age : {props.age}</h2>
  //     </>
  //   )
  // }

  // const name = 'Tabitha';
  // const isNameShowing = true;
  return (
    <div className="App">

      <button onClick={() => setCounter((prevCount) => prevCount -1)}>-</button>
      <h1>{counter}</h1>
      <button onClick={() => setCounter((prevCount) => prevCount +1)}>+</button>
      {/* <button>+</button> */}

  {/* //     <Person 
  //       name={'Monique'} 
  //       lastName={'Raley'} 
  //       age={25}
  //     />
  //     <Person name='Leah' lastName='Ward' age= {30}/> */}
     
      {/* Hello, {isNameShowing ? name : 'someone'}! */}
      {/* {name ? (
        <>
          <h1>{name}</h1>
        </>

      ): (
        <>
        <h1>test</h1>
        <h1>There is no name</h1>
        </>
      )} */}
    </div>
  );
}

export default App;
