import React from 'react'
import { Text, StyleSheet, TouchableOpacity, View, NativeModules } from 'react-native'
import useIsPiPMode from './src/hooks/useIsPiPMode';
import PiPModule from './src/NativeModules/PiPModule';

const PIP_WINDOW = {
  height: 214,
  width: 300,
}

const App = () => {
  const isPiPMode = useIsPiPMode();
  console.log('isPiPMode', isPiPMode);

  return (
    <React.Fragment>
      <View style={{flex: 1, justifyContent: 'center', alignItems: 'center'}}>
        {isPiPMode ? (
          <PiPView/>
        ) : (
          <TouchableOpacity activeOpacity={1} onPress={() => {
            PiPModule.enablePiPMode(PIP_WINDOW.width, PIP_WINDOW.height);
          }} style={styles.button}>
            <Text style={styles.title}>Press Me</Text>
          </TouchableOpacity>
        )}
      </View>
    </React.Fragment>
  )
}
export default App;

const PiPView = () => {
  return (
    <View style={{width: PIP_WINDOW.width, height: PIP_WINDOW.height, justifyContent: 'center', alignItems: 'center', backgroundColor: 'yellow'}}>
      <Text style={{color: '#000', fontSize: 16, fontWeight: 'bold'}}>PiP Mode</Text>
    </View>
  )
}

const styles = StyleSheet.create({
  button: {
    justifyContent: 'center',
    alignItems: 'center',
    width: 120,
    height: 50,
    backgroundColor: 'green',
    borderRadius: 25,
  },
  title: {
    color: 'white',
    fontSize: 16,
  }
})