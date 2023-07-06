import { useState, useEffect } from 'react';
import { Platform } from 'react-native';
import PiPModule from '../NativeModules/PiPModule';

function useIsPiPMode() {
    const [isModeEnabled, setIsPipModeEnabled] = useState(false);

    useEffect(() => {
        let pipListener;
        if (Platform.OS === 'android') {
            pipListener = PiPModule.onPipModeChanged(setIsPipModeEnabled);
        }

        return () => {
            pipListener?.remove();
        };
    }, []);

    return isModeEnabled;
}

export default useIsPiPMode;