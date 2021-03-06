/*
 * (C) Copyright 2012 Nuxeo SA (http://nuxeo.com/) and others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Contributors:
 *     Thomas Roger
 */

package org.nuxeo.ecm.csv;

/**
 * @author <a href="mailto:troger@nuxeo.com">Thomas Roger</a>
 * @since 5.7
 */
public class CSVImportStatus {

    private final State state;

    private final int positionInQueue;

    private final int queueSize;

    public enum State {
        SCHEDULED, RUNNING, COMPLETED
    }

    public CSVImportStatus(State state) {
        this(state, 0, 0);
    }

    public CSVImportStatus(State state, int positionInQueue, int queueSize) {
        this.state = state;
        this.positionInQueue = positionInQueue;
        this.queueSize = queueSize;
    }

    public State getState() {
        return state;
    }

    public int getPositionInQueue() {
        return positionInQueue;
    }

    public int getQueueSize() {
        return queueSize;
    }

    public boolean isScheduled() {
        return state == State.SCHEDULED;
    }

    public boolean isRunning() {
        return state == State.RUNNING;
    }

    public boolean isComplete() {
        return state == State.COMPLETED;
    }
}
