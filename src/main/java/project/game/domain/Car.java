package project.game.domain;

import project.game.StringUtils;

import static project.game.TextConstant.CAR_POSITION_TEXT;
import static project.game.TextConstant.RACING_CAR_POSITION_TEXT;

public class Car {

    private static final int START_POSITION = 1;

    private String mName;
    private MoveRule mMoveRule;
    private int mMovePosition = START_POSITION;

    public Car(String name, MoveRule moveRule) {
        mName = name;
        mMoveRule = moveRule;
    }

    public int moveIfPossible() {
        if (canMove()) {
            mMovePosition++;
        }

        return mMovePosition;
    }

    public boolean hasEqualPositionTo(int targetPosition) {
        return mMovePosition == targetPosition;
    }

    public int getMovePosition() {
        return mMovePosition;
    }

    public String getCurrentPositionText() {
        String carPositionLineText = StringUtils.createRepeatedCharacter(mMovePosition, CAR_POSITION_TEXT);
        return String.format(RACING_CAR_POSITION_TEXT, mName, carPositionLineText);
    }

    public String getName() {
        return mName;
    }

    private boolean canMove() {
        return mMoveRule.canMove();
    }
}
