import React from 'react';
import '@testing-library/jest-dom/extend-expect';
import { fireEvent, render } from '@testing-library/react';
import i18n from 'components/__mocks__/i18n';
import sessionMocks from 'components/__mocks__/sessionMocks';
import SessionTable from 'components/SessionTable';

describe('SessionTable', () => {
  it('shows sessions', () => {
    const { getByText } = render(<SessionTable items={sessionMocks} />);

    expect(getByText(sessionMocks[0].id.toString())).toBeInTheDocument();
    expect(getByText(sessionMocks[1].id.toString())).toBeInTheDocument();

    expect(getByText(sessionMocks[0].name)).toBeInTheDocument();
    expect(getByText(sessionMocks[1].name)).toBeInTheDocument();
  });

  it('shows no sessions message', () => {
    const { queryByText } = render(<SessionTable items={[]} />);

    expect(queryByText(sessionMocks[0].id.toString())).not.toBeInTheDocument();
    expect(queryByText(sessionMocks[1].id.toString())).not.toBeInTheDocument();

    expect(queryByText(sessionMocks[0].name)).not.toBeInTheDocument();
    expect(queryByText(sessionMocks[1].name)).not.toBeInTheDocument();

    expect(queryByText(sessionMocks[0].track)).not.toBeInTheDocument();
    expect(queryByText(sessionMocks[1].track)).not.toBeInTheDocument();

    expect(queryByText('entities.session.noItems')).toBeInTheDocument();
  });

  it('calls onSelect when the user clicks a table row', () => {
    const onSelectMock = jest.fn();
    const { getByText } = render(<SessionTable items={sessionMocks} onSelect={onSelectMock} />);

    fireEvent.click(getByText(sessionMocks[0].id.toString()));
    expect(onSelectMock).toHaveBeenCalledTimes(1);
  });
});
