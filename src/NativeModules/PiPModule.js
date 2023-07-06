import { NativeEventEmitter, NativeModules, Platform } from "react-native";

class PiPModule {
    EventEmitter;

    constructor() {
        this.EventEmitter =
            Platform.OS == 'android'
                ? new NativeEventEmitter(NativeModules.PiPModule)
                : null;
    }

    onPipModeChanged(listener) {
        return this.EventEmitter?.addListener('EVENT_PIP_MOD_CHANGE', listener);
    }

    enablePiPMode(width, height) {
        return NativeModules.PiPModule.enablePiPMode(width, height);
    }
}

export default new PiPModule();